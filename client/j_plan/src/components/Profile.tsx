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
                <strong>Token:</strong> {currentUser.accessToken.substring(0, 20)} .... {currentUser.accessToken.substring(currentUser.accessToken.length - 20)}
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