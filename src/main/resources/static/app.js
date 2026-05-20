const API_URL = 'http://localhost:8080/api';

function setToken(token, role, userId) {
    localStorage.setItem('jwtToken', token);
    localStorage.setItem('userRole', role);
    localStorage.setItem('userId', userId);
}

function getToken() {
    return localStorage.getItem('jwtToken');
}

function getRole() {
    return localStorage.getItem('userRole');
}

function getUserId() {
    return localStorage.getItem('userId');
}

function logout() {
    localStorage.clear();
    window.location.href = 'index.html';
}

function getAuthHeaders() {
    return {
        'Content-Type': 'application/json',
        'Authorization': 'Bearer ' + getToken()
    };
}

function checkAuth(requiredRole = null) {
    const token = getToken();
    const role = getRole();
    if (!token) {
        window.location.href = 'index.html';
    }
    if (requiredRole && role !== requiredRole && role !== 'ADMIN') { // ADMIN has access to all normally
        alert('Access denied');
        window.location.href = 'dashboard.html';
    }
}
