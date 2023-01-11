function writeCookie(key, value, ttlInSeconds) {
  let cookie = `${key}=${value};samesite=Lax;path=/`;

  if (ttlInSeconds) {
    let now = new Date();
    now.setTime(now.getTime() + ttlInSeconds * 1000);
    cookie += "; expires=" + now.toUTCString();
  }

  document.cookie = cookie;
}

function readCookie(key) {
  return (
    document.cookie.match("(^|;)\\s*" + key + "\\s*=\\s*([^;]+)")?.pop() || ""
  );
}

function removeCookie(key) {
  document.cookie = key + "=;Max-Age=0;samesite=Lax;path=/";
}

export const cookieHelper = { readCookie, writeCookie, removeCookie };
