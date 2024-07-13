import { InputText } from 'primereact/inputtext';
import React, { useState } from "react";
import { getCurrentUser } from "../../services/auth.service";


type Props = {}
export const TimeCard: React.FC<Props> = () => {


    const currentUser = getCurrentUser();

    // To do connect to API create timeCard;
    // ADD option to select project;

    const handleTimeCardCreation = (formValue: { username: string; start_date: Date }) => {
        const { username, start_date } = formValue;
    }

    const [text, setText] = useState('');



    return (
        <div className="col-md-12">
            <div className="card card-container">
                <form>
                    <div className="form-group p-3 text-center">
                        <label htmlFor="username">Username</label>
                        <input name="username" type='text' className="form-control" value={currentUser.username} />
                    </div>

                    <div className="form-group p-3 text-center">
                        <label htmlFor="comment">Comment</label>
                        <InputText value={text} />
                    </div>

                    <div className="form-group">
                        <label htmlFor="projectName">Project Name</label>
                        <select className="form-control">
                            <option value=""></option>
                        </select>
                    </div>
                    <div className="form-group text-center p-3">
                        <button type="submit" className="btn btn-block btn-lg btn-primary">

                            <span>register</span>
                        </button>
                    </div>
                </form>
            </div>
        </div>
    )


}