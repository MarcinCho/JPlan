import React, { useState, ChangeEvent, FormEvent } from 'react'
import { NavLink, Navigate } from 'react-router-dom'
import { Button, Form, Grid, Segment, Message } from 'semantic-ui-react'
import { useAuth } from '../../misc/AuthContext'
import { bookApi } from '../../misc/BookApi'


export function Login() {
  const Auth = useAuth()
  const isLoggedIn = Auth.userIsAuthenticated()

  const [username, setUsername] = useState<string>('')
  const [password, setPassword] = useState<string>('')
  const [isError, setIsError] = useState<boolean>(false)

  const handleInputChange = (e: ChangeEvent<HTMLInputElement>, { name, value }: any) => {
    if (name === 'username') {
      setUsername(value)
    } else if (name === 'password') {
      setPassword(value)
    }
  }

  const handleSubmit = async (e: FormEvent) => {
    e.preventDefault()

    if (!(username && password)) {
      setIsError(true)
      return
    }

    try {
      const response = await bookApi.authenticate(username, password)
      const { id, name, role } = response.data
      const authdata = window.btoa(username + ':' + password)
      const authenticatedUser = { id, name, role, authdata }

      Auth.userLogin(authenticatedUser)

      setUsername('')
      setPassword('')
      setIsError(false)
    } catch (error) {
      // handleLogError(error)
      setIsError(true)
    }
  }

  if (isLoggedIn) {
    return <Navigate to='/' />
  }

  return (
    <Grid textAlign='center'>
      <Grid.Column style={{ maxWidth: 450 }}>
        <Form size='large' onSubmit={handleSubmit}>
          <Segment>
            <Form.Input
              fluid
              autoFocus
              name='username'
              icon='user'
              iconPosition='left'
              placeholder='Username'
              value={username}
              onChange={handleInputChange}
            />
            <Form.Input
              fluid
              name='password'
              icon='lock'
              iconPosition='left'
              placeholder='Password'
              type='password'
              value={password}
              onChange={handleInputChange}
            />
            <Button color='blue' fluid size='large'>Login</Button>
          </Segment>
        </Form>
        <Message>
          {`Don't have already an account? `}
          <NavLink to="/signup" color='teal'>Sign Up</NavLink>
        </Message>
        {isError && <Message negative>The username or password provided are incorrect!</Message>}
      </Grid.Column>
    </Grid>
  )
}

export default Login