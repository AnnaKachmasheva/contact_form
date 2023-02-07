import './App.scss';
import React from 'react';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import NewRequestPage from "./pages/request/NewRequestPage";
import NewEmployeePage from "./pages/employee/NewEmployeePage";
import LoginPage from "./pages/employee/LoginPage";
import AboutUsPage from "./pages/global/AboutUsPage";
import {DocumentationPage} from "./pages/global/DocumentationPage";
import Dashboard from "./pages/employee/DashboardPage";

function App() {
    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path="/aboutus" element={<AboutUsPage/>}/>
                    <Route path="/contactus" element={<NewRequestPage/>}/>
                    <Route path="/employee" element={<NewEmployeePage/>}/>
                    <Route path="/login" element={<LoginPage/>}/>
                    <Route path="/documentation" element={<DocumentationPage/>}/>
                    <Route path="/admin/dashboard" element={<Dashboard/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;