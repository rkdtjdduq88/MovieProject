// 댓글 목록을 화면에 표시하는 함수
function showComments(comments) {
  const chatList = document.querySelector(".chat.list-group");
  chatList.innerHTML = "";

  comments.forEach((comment) => {
    const listItem = document.createElement("li");
    listItem.className = "list-group-item border-bottom";
    listItem.setAttribute("data-rno", comment.rno);

    const header = document.createElement("div");
    header.className = "d-flex justify-content-between";

    const username = document.createElement("strong");
    username.className = "primary-font";
    username.textContent = comment.userid;

    const timestamp = document.createElement("small");
    timestamp.className = "text-muted text-right";
    timestamp.textContent = comment.regDate;

    header.appendChild(username);
    header.appendChild(timestamp);

    const content = document.createElement("p");
    content.textContent = comment.replyContent;

    const buttons = document.createElement("div");
    buttons.className = "btn-group btn-group-sm";

    const editButton = document.createElement("button");
    editButton.className = "btn btn-warning";
    editButton.type = "button";
    editButton.textContent = "수정";
    editButton.addEventListener("click", () => {
      const listItem = editButton.parentNode.parentNode; // 부모 요소인 li.list-group-item을 가져옵니다.
      const content = listItem.querySelector("p"); // 댓글 내용을 나타내는 p 요소를 가져옵니다.

      if (content) {
        const editInput = document.createElement("input"); // 수정을 위한 입력 필드인 input 요소를 생성합니다.
        editInput.type = "text";
        editInput.className = "form-control";
        editInput.value = content.textContent;
        content.replaceWith(editInput); // 기존의 p 요소를 수정용 입력 필드로 교체합니다.

        editButton.textContent = "확인";
        editButton.addEventListener("click", () => {
          const rno = listItem.getAttribute("data-rno"); // 수정할 댓글의 rno 값을 가져옵니다.
          const newContent = editInput.value; // 수정된 내용을 가져옵니다.
          updateComment(rno, newContent); // 수정 기능을 호출하여 댓글을 업데이트합니다.

          const newContentText = document.createElement("p"); // 수정된 내용을 나타낼 새로운 p 요소를 생성합니다.
          newContentText.textContent = newContent;
          editInput.replaceWith(newContentText); // 수정용 입력 필드를 새로운 p 요소로 교체합니다.

          editButton.textContent = "수정";
        });

        editInput.focus(); // 수정용 입력 필드에 포커스를 설정합니다.
      }
    });

    const deleteButton = document.createElement("button");
    deleteButton.className = "btn btn-danger";
    deleteButton.type = "button";
    deleteButton.textContent = "삭제";
    deleteButton.addEventListener("click", () => {
      const rno = comment.rno; // 해당 댓글의 rno 가져오기
      deleteComment(rno); // 댓글 삭제 함수 호출
    });

    // 댓글 삭제 함수
    function deleteComment(rno) {
      fetch(`/blog-details/${bno}/comment/${rno}/delete`, {
        method: "POST",
      })
        .then((response) => {
          if (response.ok) {
            // 댓글 삭제 성공 시
            console.log("Comment deleted successfully.");
            removeCommentFromUI(rno); // 화면에서 댓글 제거
          } else {
            // 댓글 삭제 실패 시
            console.error("Failed to delete comment.");
          }
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    }

    buttons.appendChild(editButton);
    buttons.appendChild(deleteButton);

    listItem.appendChild(header);
    listItem.appendChild(content);
    listItem.appendChild(buttons);

    chatList.appendChild(listItem);
  });
}

// 댓글 목록을 서버로부터 가져오는 함수
function getCommentsByBoard(bno) {
  fetch(`/api/comments/${bno}`)
    .then((response) => response.json())
    .then((data) => {
      showComments(data);
    })
    .catch((error) => {
      console.error("Error:", error);
    });
}

// 페이지 로드 시 초기 댓글 목록을 가져오기

getCommentsByBoard(bno);

// 화면에서 댓글 제거하는 함수
function removeCommentFromUI(rno) {
  const commentElement = document.querySelector(`li[data-rno="${rno}"]`);
  if (commentElement) {
    commentElement.remove();
  }
}

// 댓글 수정 함수
function updateComment(rno, replyContent) {
  const data = {
    replyContent: replyContent,
  };

  fetch(`/blog-details/${bno}/comment/${rno}/update`, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data),
  })
    .then((response) => {
      if (response.ok) {
        // 댓글 수정 성공 시
        console.log("Comment updated successfully.");
        updateCommentInUI(rno, replyContent); // 화면에서 댓글 업데이트
      } else {
        // 댓글 수정 실패 시
        console.error("Failed to update comment.");
      }
    })
    .catch((error) => {
      console.error("Error:", error);
    });
}

// 화면에서 댓글 업데이트하는 함수
function updateCommentInUI(rno, replyContent) {
  const commentElement = document.querySelector(`li[data-rno="${rno}"]`);
  if (commentElement) {
    const contentElement = commentElement.querySelector("p");
    if (contentElement) {
      contentElement.textContent = replyContent;
    }
  }
}