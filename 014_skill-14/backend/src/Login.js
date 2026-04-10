import { useState } from "react";
import { useNavigate } from "react-router-dom";

function Login() {
  const [user, setUser] = useState({ username: "", password: "" });
  const nav = useNavigate();

  const login = () => {
    fetch("http://localhost:8080/api/login", {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify(user)
    })
    .then(res => res.text())
    .then(data => {
      if(data === "SUCCESS") {
        localStorage.setItem("user", user.username);
        nav("/home");
      } else {
        alert("Invalid credentials");
      }
    });
  };

  return (
    <>
      <h2>Login</h2>
      <input placeholder="Username"
        onChange={e=>setUser({...user, username:e.target.value})}/>
      <input placeholder="Password"
        onChange={e=>setUser({...user, password:e.target.value})}/>
      <button onClick={login}>Login</button>
      <p onClick={()=>nav("/register")}>Go to Register</p>
    </>
  );
}
export default Login;