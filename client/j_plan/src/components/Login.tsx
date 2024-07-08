import React, { useState } from "react";
import { NavigateFunction, useNavigate } from "react-router-dom";
import * as Yup from "yup";
import { login } from "../services/auth.service";
import { ErrorMessage, Field, Form, Formik } from "formik";


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
                <img src="source.boringavatars.com/beam/120/Stefan?colors=264653,f4a261,e76f51" alt="profile-img" className="profile-img-card" />
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

// import React, { useState, ChangeEvent, FormEvent } from 'react'
// import { NavLink, Navigate } from 'react-router-dom'
// import { useAuth } from '../../misc/AuthContext'
// import { bookApi } from '../../misc/BookApi'


// export function Login() {
//   const Auth = useAuth()
//   const isLoggedIn = Auth.userIsAuthenticated()

//   const [username, setUsername] = useState<string>('')
//   const [password, setPassword] = useState<string>('')
//   const [isError, setIsError] = useState<boolean>(false)

//   const handleInputChange = (e: ChangeEvent<HTMLInputElement>, { name, value }: any) => {
//     if (name === 'username') {
//       setUsername(value)
//     } else if (name === 'password') {
//       setPassword(value)
//     }
//   }

//   const handleSubmit = async (e: FormEvent) => {
//     e.preventDefault()

//     if (!(username && password)) {
//       setIsError(true)
//       return
//     }

//     try {
//       const response = await bookApi.authenticate(username, password)
//       const { id, name, role } = response.data
//       const authdata = window.btoa(username + ':' + password)
//       const authenticatedUser = { id, name, role, authdata }

//       Auth.userLogin(authenticatedUser)

//       setUsername('')
//       setPassword('')
//       setIsError(false)
//     } catch (error) {
//       // handleLogError(error)
//       setIsError(true)
//     }
//   }

//   if (isLoggedIn) {
//     return <Navigate to='/' />
//   }

//   return (
//     <Grid textAlign='center'>
//       <Grid.Column style={{ maxWidth: 450 }}>
//         <Form size='large' onSubmit={handleSubmit}>
//           <Segment>
//             <Form.Input
//               fluid
//               autoFocus
//               name='username'
//               icon='user'
//               iconPosition='left'
//               placeholder='Username'
//               value={username}
//               onChange={handleInputChange}
//             />
//             <Form.Input
//               fluid
//               name='password'
//               icon='lock'
//               iconPosition='left'
//               placeholder='Password'
//               type='password'
//               value={password}
//               onChange={handleInputChange}
//             />
//             <Button color='blue' fluid size='large'>Login</Button>
//           </Segment>
//         </Form>
//         <Message>
//           {`Don't have already an account? `}
//           <NavLink to="/signup" color='teal'>Sign Up</NavLink>
//         </Message>
//         {isError && <Message negative>The username or password provided are incorrect!</Message>}
//       </Grid.Column>
//     </Grid>
//   )
// }

// export default Login
