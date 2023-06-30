/**
 *
 */
function getQueryParam(param) {
  const urlParams = new URLSearchParams(window.location.search);
  return urlParams.get(param);
}

const userid = getQueryParam("userid");
console.log(userid);
