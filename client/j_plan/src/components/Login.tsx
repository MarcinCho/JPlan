import React, { useState } from "react";
import { NavigateFunction, useNavigate } from "react-router-dom";
import * as Yup from "yup";
import { login } from "../services/auth.service";
import { ErrorMessage, Field, Form, Formik } from "formik";
import Avatar from 'boring-avatars';

<Avatar
    size={40}
    name="Maria Mitchell"
    variant="marble"
    colors={['#92A1C6', '#146A7C', '#F0AB3D', '#C271B4', '#C20D90']}
/>;

type Props = {}

export const Login: React.FC<Props> = () => {

    let navigate: NavigateFunction = useNavigate();

    const [loading, setLoading] = useState<boolean>(false);
    const [message, setMessage] = useState<String>("");

    const initialValues: {
        username: string;
        password: string;
    } = {
        username: "",
        password: "",
    };

    const validationSchema = Yup.object().shape({
        username: Yup.string().required("This field is requierd"),
        password: Yup.string().required("This field is requierd")
    })

    const handleLogin = (formValue: { username: string; password: string }) => {
        const { username, password } = formValue;

        setMessage("");
        setLoading(true);

        login(username, password).then(
            () => {
                navigate('/profile');
                window.location.reload();
            },
            (error) => {
                const resMessage = (error.response && error.response.data && error.response.data.message) || error.message || error.toString();
                setLoading(false);
                setMessage(resMessage);
            }
        );
    };

    return (
        <div className="col-md-12">
            <div className="card card-container">
                <img src="https://source.boringavatars.com/beam/120/MaryBaker" alt="profile-img" className="profile-img-card" />
                <Formik
                    initialValues={initialValues}
                    validationSchema={validationSchema}
                    onSubmit={handleLogin}
                >
                    <Form>
                        <div className="form-group">
                            <label htmlFor="username">Username</label>
                            <Field name="username" type='text' className="form-control" />
                            <ErrorMessage name="password" component="div" className="alert alert-danger" />
                        </div>

                        <div className="form-group">
                            <label htmlFor="password">Password</label>
                            <Field name="password" type="password" className="form-control" />
                            <ErrorMessage
                                name="password"
                                component="div"
                                className="alert alert-danger"
                            />
                        </div>

                        <div className="form-group">
                            <button type="submit" className="btn btn-block btn-lg btn-primary " disabled={loading}>
                                {loading && (<span className="spinner-border spinner-border-sm"></span>)}
                                <span>Login</span>
                            </button>
                        </div>
                        {message && (<div className="form-group">
                            <div className="alert alert-danger" role='alert'>
                                {message}
                            </div>
                        </div>)}
                    </Form>
                </Formik>
            </div>
        </div>
    )
}

