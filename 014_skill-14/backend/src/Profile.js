import { useEffect, useState } from "react";

function Profile() {
  const [data, setData] = useState({});
  const user = localStorage.getItem("user");

  useEffect(() => {
    fetch(`http://localhost:8080/api/profile/${user}`)
      .then(res => res.json())
      .then(setData);
  }, []);

  return (
    <>
      <h2>Profile</h2>
      <p>Username: {data.username}</p>
    </>
  );
}
export default Profile;