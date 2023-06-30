package com.project.movie.controller;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.domain.AttachFileDTO;
import com.spring.domain.BoardDTO;
import com.spring.domain.Criteria;
import com.spring.domain.PageDTO;
import com.spring.service.BoardService;

import lombok.extern.slf4j.Slf4j;
//import oracle.jdbc.proxy.annotation.Post;

@Controller
@Slf4j

public class MovieBoardController {
	@Autowired
	public BoardService service;

	@GetMapping("/list")
	public void getRows(Criteria criteria, Model model) {
		log.info("��ü ����Ʈ ��� ��û ");
		log.info("type" + Arrays.toString(criteria.getTypeArr()));
		// ����ڰ� ��û�� ��ȣ�� �´� �Խù� ���
		List<BoardDTO> list = service.getList(criteria);
		// ��ü �Խù� ����
		int total = service.getTotalCnt(criteria);
		model.addAttribute("list", list);
		model.addAttribute("pageDTO", new PageDTO(criteria, total));
	}
	@PreAuthorize("isAuthenticated()")
	@GetMapping("/register")
	public void registerGet() {
		log.info("register �� ��û");
	}
	
	@PreAuthorize("isAuthenticated()")//�������� ������ �ִ�?
	@PostMapping("/register")
	public String registerPost(BoardDTO boardDTO, RedirectAttributes rttr, Criteria cri) {
		log.info("register ��� ��û" + boardDTO);
		// ÷������Ȯ��
//	    if(boardDTO.getAttachList() != null) {
//	    	boardDTO.getAttachList().forEach(attach -> log.info(attach.toString()));
//	    }
		if (service.register(boardDTO)) {
			log.info("�� ��ȣ: " + boardDTO.getBno());
			rttr.addFlashAttribute("result", boardDTO.getBno());
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("amount", cri.getAmount());
			return "redirect:/board/list";
		}
		return "/board/register";
	}

	@GetMapping({ "/read", "/modify" })
	public void readGet(int bno, Model model, @ModelAttribute("cri") Criteria criteria) {
		log.info("������ ��û" + bno);
		BoardDTO dto = service.read(bno);
		model.addAttribute("read", dto);

	}

	@PreAuthorize("principal.username == #boardDTO.writer")//�α��� ����� == �ۼ���
	@PostMapping("/modify")
	public String modifyPost(BoardDTO boardDTO, RedirectAttributes rttr, Criteria cri) {
		log.info("���� �� ����" + cri);
		if (service.modify(boardDTO)) {
			rttr.addFlashAttribute("result", "success");
			rttr.addAttribute("page", cri.getPage());
			rttr.addAttribute("amount", cri.getAmount());
			rttr.addAttribute("type", cri.getType());
			rttr.addAttribute("keyword", cri.getKeyword());
			return "redirect:/board/list";
		} else {
			return "/board/modify";
		}

	}

	@PreAuthorize("principal.username == #writer") //�α��� ����� = �ۼ���
	@GetMapping("/remove")
	public String removeGet(int bno, String writer,RedirectAttributes rttr, @ModelAttribute("cri") Criteria cri) {
		log.info("���� ��û" + bno);
		// ���ε�� ���� ���� �޼ҵ� ȣ��
		List<AttachFileDTO> attachList = service.getAttachList(bno);
		deleteAttachFiles(attachList);
		// ������ ����Ʈ
		service.remove(bno);
		rttr.addFlashAttribute("result", "success");

		// ���������������� �ּ��ٿ�������
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("amount", cri.getAmount());
		// �˻�����
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/list";

	}

	// ÷������ ��������
	@GetMapping("/getAttachList")
	public ResponseEntity<List<AttachFileDTO>> attachList(int bno) {
		return service.getAttachList(bno) != null
				? new ResponseEntity<List<AttachFileDTO>>(service.getAttachList(bno), HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	private void deleteAttachFiles(List<AttachFileDTO> attachList) {
		log.info("÷������ �������� ����");
		if (attachList == null || attachList.size() <= 0)
			return;
		for (AttachFileDTO dto : attachList) {
			// ���� ���
			Path path = Paths
					.get("c:\\uploads\\" + dto.getUploadPath() + "\\" + dto.getUuid() + "_" + dto.getFileName());
			try {
				Files.deleteIfExists(path);
				// �̹��� ������ ��� ����ϵ� ����
				if (Files.probeContentType(path).startsWith("image")) {
					Path thumb = Paths.get(
							"c:\\uploads\\" + dto.getUploadPath() + "\\s_" + dto.getUuid() + "_" + dto.getFileName());
					Files.deleteIfExists(thumb);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
