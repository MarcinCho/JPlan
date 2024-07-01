import { useState } from "react"
import { NavLink } from "react-router-dom"
import { Button, Form, Grid, Message, Segment } from "semantic-ui-react"
import { isError } from "util"


export const Login = () => {

    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [isError, setIsError] = useState(false)

    const handleInputChange = (e, {name: string, value: string}) => {
        if (name === 'username') {
            setUsername(value)
        } else if (name === 'password') {
            setPassword(value)
        }
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
          <Message>{`Don't have already an account? `}
            <NavLink to="/signup" as={NavLink} color='teal'>Sign Up</NavLink>
          </Message>
          {isError && <Message negative>The username or password provided are incorrect!</Message>}
        </Grid.Column>
      </Grid>
    )
}
