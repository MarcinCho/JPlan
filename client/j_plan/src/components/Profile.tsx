import React from "react";
import { getCurrentUser } from "../services/auth.service";


export const Profile: React.FC = () => {
    const currentUser = getCurrentUser();

    return (
        <div className="container">
            <header className="jumbotron">
                <h3>
                    <strong>{currentUser.username}</strong> Profile
                </h3>
            </header>
            <p>
                <strong>Token:</strong> {currentUser.token.substring(0, 20)} .... {currentUser.token.substring(currentUser.token.length - 20)}
            </p>
            <p>
                <strong>Email </strong> {currentUser.email}
            </p>
            <p>
                <strong>Authorities</strong>
                <ul>
                    {currentUser.roles && currentUser.roles.map((role: string, index: number) => <li key={index}>{role}</li>)}
                </ul>
            </p>


        </div>
    )
}