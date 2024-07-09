import axios from 'axios';

const API_URL = "http://localhost:8080/auth/";

export const register = (username: string, userEmail: string, password: string) =>{
    return axios.post(API_URL + "register", {
        username,
        userEmail,
        password,
    });
};

export const login = (username: string, password: string) =>{
    return axios.post(API_URL + "login", {
        username,
        password,
    })
    .then((response) => {
        
        if (response.data){
            localStorage.setItem("user", JSON.stringify(response.data));
            console.log(response.data);
        } else {
            console.log("It aint workin")
        }
        return response.data;
    })
};

export const logout = () => {
    localStorage.removeItem("user");
};

export const getCurrentUser = () => {
    const userStr = localStorage.getItem("user");
    if (userStr)
        return JSON.parse(userStr);
    return null;
};