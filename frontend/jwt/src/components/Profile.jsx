import React, { useEffect, useRef, useState } from 'react';
import './Profile.css';
import { BACKENDURL, callApi } from '../lib';

const Profile = () => {
    const [userData, setUserData] = useState(null);
    const fileUpload = useRef();
    const dpImage = useRef();
    const [userImage, setUserImage] = useState(null);

    useEffect(()=>{
        const token = localStorage.getItem("token");
        callApi("GET", BACKENDURL + "users/getuser", "", loadData, token);
    }, []);

    function loadData(res){
        const data = JSON.parse(res);
        setUserData(data);
        setUserImage(data.img)
    }

    function changeImage(){
        fileUpload.current.value = "";
        fileUpload.current.click();
    }

    function uploadImage(e){
        let formData = new FormData();
        formData.append('FILE', e.target.files[0]); 
        const token = localStorage.getItem("token");
        callApi("POST", BACKENDURL + "users/uploadimage", formData, uploadResponse, token, true);
    }

    function uploadResponse(res){
        const data = JSON.parse(res);
        if(data.code != 200)
            return;
        setUserImage(data.img);
        alert(data.msg);
    }

    if(!userData) return(<p>Loading....</p>);

    return (
        <div className='profile'>
            <div className='panel'>
                <div className='meta-info'>
                    <img src={userImage} ref={dpImage} alt='dp' onClick={()=>changeImage()} />
                    <input type='file' ref={fileUpload} accept='image/jpeg,image/png' style={{'display':'none'}} onChange={(e)=>uploadImage(e)} />
                    <div>
                        <span>{userData.user.fname} {userData.user.lname}</span>
                        <span className='role'>{userData.roles.rolename}</span>
                    </div>
                </div>
                <div className='user-info'>
                    <div>
                        <span>First Name</span>
                        <span>{userData.user.fname}</span>
                    </div>
                    <div>
                        <span>Last Name</span>
                        <span>{userData.user.lname}</span>
                    </div>
                    <div>
                        <span>Mobile Number</span>
                        <span>{userData.user.mobile}</span>
                    </div>
                    <div>
                        <span>Email ID</span>
                        <span>{userData.user.email}</span>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Profile;
