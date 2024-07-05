import axios, { AxiosResponse } from 'axios'
import { config } from './Constants';


interface User {
    id: string;
    name: string;
    role: string;
    authdata: string;
}

interface Book {
    isbn: string;
    title: string;
    author: string;
    [key: string]: any; // Additional properties if any
}

export const bookApi = {
    authenticate,
    // signup,
    // numberOfUsers,
    // numberOfBooks,
    // getUsers,
    // deleteUser,
    // getBooks,
    // deleteBook,
    // addBook
}

function authenticate(username: string, password: string): Promise<AxiosResponse> {
    return instance.post('/auth/authenticate', { username, password }, {
        headers: { 'Content-type': 'application/json' }
    })
}

// function signup(user: Partial<User>): Promise<AxiosResponse> {
//     return instance.post('/auth/signup', user, {
//         headers: { 'Content-type': 'application/json' }
//     })
// }

// function numberOfUsers(): Promise<AxiosResponse> {
//     return instance.get('/public/numberOfUsers')
// }

// function numberOfBooks(): Promise<AxiosResponse> {
//     return instance.get('/public/numberOfBooks')
// }

// function getUsers(user: User, username?: string): Promise<AxiosResponse> {
//     const url = username ? `/api/users/${username}` : '/api/users'
//     return instance.get(url, {
//         headers: { 'Authorization': basicAuth(user) }
//     })
// }

// function deleteUser(user: User, username: string): Promise<AxiosResponse> {
//     return instance.delete(`/api/users/${username}`, {
//         headers: { 'Authorization': basicAuth(user) }
//     })
// }

// function getBooks(user: User, text?: string): Promise<AxiosResponse> {
//     const url = text ? `/api/books?text=${text}` : '/api/books'
//     return instance.get(url, {
//         headers: { 'Authorization': basicAuth(user) }
//     })
// }

// function deleteBook(user: User, isbn: string): Promise<AxiosResponse> {
//     return instance.delete(`/api/books/${isbn}`, {
//         headers: { 'Authorization': basicAuth(user) }
//     })
// }

// function addBook(user: User, book: Book): Promise<AxiosResponse> {
//     return instance.post('/api/books', book, {
//         headers: {
//             'Content-type': 'application/json',
//             'Authorization': basicAuth(user)
//         }
//     })
// }

// -- Axios

const instance = axios.create({
    baseURL: config.url.API_BASE_URL
})

// -- Helper functions

function basicAuth(user: User): string {
    return `Basic ${user.authdata}`
}
