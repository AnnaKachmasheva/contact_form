import React from 'react';
import {BrowserRouter, Route, Routes} from "react-router-dom";
import NewRequestPage from "./pages/NewRequestPage";
import NewEmployeePage from "./pages/NewEmployeePage";

function App() {
    return (
        <div>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<NewRequestPage/>}/>
                    <Route path="/employee" element={<NewEmployeePage/>}/>
                </Routes>
            </BrowserRouter>
        </div>
    );
}

export default App;