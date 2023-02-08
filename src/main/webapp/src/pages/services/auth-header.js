export default function authHeader() {
    const employee = JSON.parse(localStorage.getItem('employee'));
    if (employee && employee.accessToken) {
        return {
            Authorization: 'Bearer ' + employee.accessToken, 'Content-Type': 'application/json',
            'Accept': 'application/json'
        };
    } else {
        return {};
    }
}

