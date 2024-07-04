export default interface IUser {
    username: string,
    email: string,
    password: string,
    roles?: Array<string>
}