import { useNavigate } from "react-router-dom";

function Home() {
  const nav = useNavigate();
  const user = localStorage.getItem("user");

  if(!user) nav("/");

  return (
    <>
      <h2>Welcome {user}</h2>
      <button onClick={()=>nav("/profile")}>Profile</button>
      <button onClick={()=>{
        localStorage.removeItem("user");
        nav("/");
      }}>Logout</button>
    </>
  );
}
export default Home;