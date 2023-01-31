import React from 'react';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import NewRequestPage from "./pages/request/NewRequestPage";
import NewEmployeePage from "./pages/employee/NewEmployeePage";
import LoginPage from "./pages/employee/LoginPage";

function App() {
    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path="/contactus" element={<NewRequestPage/>}/>
                    <Route path="/employee" element={<NewEmployeePage/>}/>
                    <Route path="/login" element={<LoginPage/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;