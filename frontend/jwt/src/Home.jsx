import React, { useEffect, useState } from 'react';
import { BACKENDURL, callApi } from './lib';
import './Home.css';
import Dashboard from './components/Dashboard.jsx';
import MyTask from './components/MyTask.jsx';
import TaskManager from './components/TaskManager.jsx';
import UserManager from './components/UserManager.jsx';
import Profile from './components/Profile.jsx';

const Home = () => {
    const [fullname, setfullName] = useState("");
    const [menuList, setMenuList] = useState([]);
    const [activeComponent, setActiveComponent] = useState(<Dashboard/>);
    const [activeMenu, setActiveMenu] = useState(1);

    useEffect(()=>{
        const token = localStorage.getItem("token");
        if(!token)
            window.location.replace("/");

        callApi("GET", BACKENDURL + "users/uinfo", "", getUserFullName, token);
    },[]);

    function getUserFullName(res){
        const data = JSON.parse(res);
        if(data.code != 200)
        {
            alert(data.msg);
            return;
        }
        setfullName(data.fullname);
        setMenuList(data.menulist);
    }

    function logout(){
        localStorage.clear();
        window.location.replace("/");
    }

    function loadComponent(menuid){
        setActiveMenu(menuid);
        switch(menuid)
        {
            case 1:
                setActiveComponent(<Dashboard/>);
                break;
            case 2:
                setActiveComponent(<MyTask/>);
                break;
            case 3:
                setActiveComponent(<TaskManager/>);
                break;
            case 4:
                setActiveComponent(<UserManager/>);
                break;
            case 5:
                setActiveComponent(<Profile/>);
                break;
            default:
                setActiveComponent(null);
        }
    }

    return (
        <div className='home'>
            <div className='menus'>
                <ul>
                    {menuList.map((menu)=>(
                        <li className={menu.menuid == activeMenu? 'active': ''} key={menu.menuid} onClick={()=>loadComponent(menu.menuid)}>{menu.menuname}</li>
                    ))}
                </ul>
            </div>
            <div className='workspace'>
                <div className='ws-header'>
                    <span>{fullname}</span>
                    <img src="/logout.png" alt='logout' onClick={()=>logout()} />
                </div>
                <div className='ws-content'>{activeComponent}</div>
                <div className='ws-footer'>Copyright @ 2026. All rights reserved.</div>
            </div>
        </div>
    );
}

export default Home;
