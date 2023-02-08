import axios from 'axios';
import {baseUrl} from "../../config/const";

const login = (email, password) => {
    return (axios.post(`${baseUrl}/login`,
        {
            "email": email,
            "password": password
        }).then(response => {
        if (response.data.accessToken) {
            localStorage.setItem('employee', JSON.stringify(response.data));
        }
        return response.data
    }));
}

const logout = () => {
    localStorage.removeItem('employee');
}

// const register = (firstname, lastname, username, email, password, userType) => {
//     return (axios.post(`${baseUrl}/users`, {
//         "firstName": firstname,
//         "lastName": lastname,
//         "username": username,
//         "email": email,
//         "password": password,
//         "userType": userType
//     }));
// }

const getCurrentUser = () => {
    return JSON.parse(localStorage.getItem('employee'));
}

const AuthService = {
    register, login, logout, getCurrentUser,
};

export default AuthService;