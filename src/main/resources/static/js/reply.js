function toggleReplyForm(event) {
  event.preventDefault();
  var replyFormContainer = this.parentElement.nextElementSibling;
  var allReplyForms = document.querySelectorAll('.blog__details__comment__reply__form');

  if (replyFormContainer) {
    var replyForm = replyFormContainer.querySelector('form');

    // Close all other reply forms
    allReplyForms.forEach(function(form) {
      if (form !== replyFormContainer) {
        form.style.display = 'none';
      }
    });

    if (replyFormContainer.style.display === 'none') {
      replyFormContainer.style.display = 'block';
      replyForm.reset();

     // Scroll down to the reply form with an offset
      var offset = window.innerHeight ; // Adjust the offset value as per your preference
      var topOffset = replyFormContainer.offsetTop + offset;
      window.scrollTo({ top: topOffset, behavior: 'smooth' });
    } else {
      replyFormContainer.style.display = 'none';
    }
  }
}

// Get all reply button elements
var replyButtons = document.querySelectorAll('.reply-btn');

// Add click event listener to each reply button
replyButtons.forEach(function(replyButton) {
  replyButton.addEventListener('click', toggleReplyForm);
});