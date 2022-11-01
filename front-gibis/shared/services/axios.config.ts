import axios from "axios";

const httpClient = axios.create({
  baseURL: "http://localhost:8080/api/gibis",
  headers: {
      "Content-Type": "application/json",
      Accept: "application/json",
  },
});

export default httpClient;
