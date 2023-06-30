function toggleReplyForm(event) {
  event.preventDefault();

  var replyFormContainer = this.parentElement.querySelector(
    ".blog__details__comment__reply__form"
  );

  if (replyFormContainer) {
    var replyForm = replyFormContainer.querySelector("form");

    // 다른 모든 대댓글 폼 닫기
    var allReplyForms = document.querySelectorAll(
      ".blog__details__comment__reply__form"
    );
    allReplyForms.forEach(function (form) {
      if (form !== replyFormContainer) {
        form.style.display = "none";
      }
    });

    if (replyFormContainer.style.display === "none") {
      replyFormContainer.style.display = "block";
    } else {
      replyFormContainer.style.display = "none";
    }
  }
}

// 대댓글 버튼에 클릭 이벤트 리스너 추가
var replyButtons = document.querySelectorAll(".reply-btn");
replyButtons.forEach(function (button) {
  button.addEventListener("click", toggleReplyForm);
});
$(document).on("click", ".edit-btn", function () {
  var commentItem = $(this).closest(".blog__details__comment__item");
  var commentContent = commentItem.find(".comment-content");
  var editBtn = $(this);
  var confirmBtn = commentItem.find(".update-btn");

  commentContent.attr("contenteditable", "true"); // Enable editing of comment content
  commentContent.focus(); // Set focus to the comment content
  editBtn.hide(); // Hide the edit button
  confirmBtn.show(); // Show the confirmation button
});

$(document).on("click", ".update-btn", function () {
  var commentId = $(this).attr("data-rno");
  var commentItem = $(this).closest(".blog__details__comment__item");
  var commentContent = commentItem.find(".comment-content");
  var editBtn = commentItem.find(".edit-btn");
  var confirmBtn = $(this);

  commentContent.attr("contenteditable", "false"); // Disable editing of comment content
  editBtn.show(); // Show the edit button
  confirmBtn.hide(); // Hide the confirmation button

  // Send an AJAX request to update the comment content
  $.ajax({
    type: "POST",
    url: `/blog-details/${bno}/comment/${commentId}/update`,
    contentType: "application/json", // Set the content type to JSON
    data: JSON.stringify({ replyContent: commentContent.text() }), // Serialize the data as JSON
    success: function (response) {
      // Handle the response or perform any necessary UI updates
      console.log("Comment updated successfully.");
    },
    error: function (error) {
      // Handle the error response or show an error message
    },
  });
});

$(document).on("click", ".delete-btn", function () {
  var commentId = $(this).attr("data-rno");
  var commentUserid = $(this).siblings(".comment-userid").text();
  var commentContainer = $(this).closest(".comment-container"); // Get the comment container element

  if (commentUserid === loggedInUser) {
    // User is allowed to delete the comment
    console.log("Delete action allowed");
    // Add your code to perform the deletion here

    // Send an AJAX request to the delete controller endpoint
    $.ajax({
      type: "POST",
      url: `/blog-details/${bno}/comment/${commentId}/delete`,
      success: function (response) {
        // Handle the response or perform any necessary UI updates
        // For example, you can remove the deleted comment from the UI
        console.log("Comment deleted successfully.");
        commentContainer.remove(); // Remove the deleted comment from the UI
        location.reload(); // Refresh the page to reflect the updated comments
      },
      error: function (error) {
        // Handle the error response or show an error message
      },
    });
  } else {
    // User is not allowed to delete the comment
    console.log("Delete action not allowed");
    // Add your code to show an error message or take appropriate action
  }
});

// Scroll to the newly added comment
function scrollToComment(commentId) {
  const commentElement = document.getElementById(commentId);
  if (commentElement) {
    commentElement.scrollIntoView({ behavior: "smooth", block: "center" });
  }
}
