import React, { useState } from "react";
import { NavigateFunction, useNavigate } from "react-router-dom";
import * as Yup from "yup";
import { register } from "../services/auth.service";
import { ErrorMessage, Field, Form, Formik } from "formik";
import IUser from "../types/user";



type Props = {}

export const Register: React.FC<Props> = () => {
    const [success, setSuccess] = useState<boolean>(false);
    const [message, setMessage] = useState<String>("");

    const initialValues: IUser = {
        username: "",
        email: "",
        password: "",
    };

    const validationSchema = Yup.object().shape({
        username: Yup.string()
            .test("len", "The username must be between 3 and 20 characters.", (val: any) => val && val.toString().length >= 3 && val.toString().length <= 20)
            .required("This field is requierd"),

        email: Yup.string()
            .email("This is not a valid e-mail!")
            .required("This field is required"),

        password: Yup.string()
            .test("len", "Password must be between 6 and 40 characters.", (val: any) => val && val.toString().length >= 6 && val.toString().length <= 40)
            .required("This field is requierd")
    })

    const handleRegister = (formValue: IUser) => {
        const { username, email, password } = formValue;

        register(username, email, password).then(
            (response) => {
                setMessage(response.data.message);
                setSuccess(true);
            },
            (error) => {
                const resMessage =
                    (error.response &&
                        error.response.data &&
                        error.response.data.message) || error.message || error.toString();

                setMessage(resMessage);
                setSuccess(false);
            });
    }


    return (
        <div className="col-md-12">
            <div className="card card-container">
                <Formik
                    initialValues={initialValues}
                    validationSchema={validationSchema}
                    onSubmit={handleRegister}
                >
                    <Form>
                        {!success && (
                            <div>
                                <div className="form-group">
                                    <label htmlFor="username"> Username </label>
                                    <Field name="username" type="text" className="form-control" />
                                    <ErrorMessage
                                        name="username"
                                        component="div"
                                        className="alert alert-danger"
                                    />
                                </div>

                                <div className="form-group">
                                    <label htmlFor="email"> Email </label>
                                    <Field name="email" type="text" className="form-control" />
                                    <ErrorMessage
                                        name="email"
                                        component="div"
                                        className="alert alert-danger"
                                    />
                                </div>

                                <div className="form-group">
                                    <label htmlFor="password"> Password </label>
                                    <Field name="password" type="password" className="form-control" />
                                    <ErrorMessage
                                        name="password"
                                        component="div"
                                        className="alert alert-danger"
                                    />
                                </div>

                                <div className="form-group">
                                    <button type="submit" className="btn btn-primary btn-block">Register</button>
                                </div>
                            </div>
                        )}

                        {message && (
                            <div className="form-group">
                                <div className={success ? "alert alert-success" : "alert alert-danger"} role='alert'>{message}</div>
                            </div>
                        )}
                    </Form>
                </Formik>
            </div>
        </div>
    )
}