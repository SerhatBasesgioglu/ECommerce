const baseUrl = "http://172.26.230.6:8080";

export const get = async (uri) => {
  return execute("get", uri, null);
};

export const post = async (uri) => {
  return execute("post", uri, data);
};

const execute = async (method, uri, data) => {
  const path = baseUrl + uri;
  let response;
  switch (method) {
    case "get":
      response = await fetch(path, { cache: "no-store" });
      break;
    case "post":
      response = await fetch(path);
  }
  return await response.json();
};
