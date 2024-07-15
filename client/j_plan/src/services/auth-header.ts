export default function authHeader() {
  const userStr = localStorage.getItem("user");
  let user = null;
  if (userStr) user = JSON.parse(userStr);
  const token = "Bearer " + user.token;
  if (user && user.token) {
    return {
      Authorization: token,
    };
  } else {
    return { Authorization: "" };
  }
}
