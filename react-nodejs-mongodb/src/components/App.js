import React from 'react';
import '../style/App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbar from 'react-bootstrap/Navbar';
import InputGroup from 'react-bootstrap/InputGroup';
import Form from 'react-bootstrap/Form';
import FormControl from 'react-bootstrap/FormControl'
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';

const todoStates = {
  COMPLETED:0,
  REMAINING:1
}

const appTitle = 'ToDo!';
const appAbout = 'App created with React and MongoDB! by Josue Rojas\n JOSUERV99 on Github!';

function App() {
  return (
    <div className="App">

      {/* app header */}
      <header className="App-header">
      <Navbar className="bg-light justify-content-between">
        <Navbar.Brand href="/" className="App-title">
          {appTitle}
        </Navbar.Brand>
        <Form inline>
          <InputGroup>
            <InputGroup.Prepend>
              <InputGroup.Text id="basic-addon1"></InputGroup.Text>
            </InputGroup.Prepend>
            <FormControl
              placeholder="Write your todo"
              aria-label="Todo"
              aria-describedby="basic-addon1"
            />
          </InputGroup>
        </Form>
        <Form inline>
          <FormControl type="text" placeholder="" className=" mr-sm-2" />
          <Button type="submit">Search</Button>
        </Form>
      </Navbar>
      </header>

      {/* app content */}
      <div className="App-content">
        <div className="App-todo">

          {/*  some examples... */}
          <Card
            bg="info"
            key={todoStates.COMPLETED}
            text="Info"
            style={{ width: '18rem' }}
            className="mb-2"
          >
            <Card.Body>
              <Card.Title> First TODO! </Card.Title>
              <Card.Text>
                Some quick example text for todo's detail
              </Card.Text>
            </Card.Body>
          </Card>

          <Card
            bg="danger"
            key={todoStates.REMAINING}
            text="Danger"
            style={{ width: '18rem' }}
            className="mb-2"
          >
            <Card.Header>Header</Card.Header>
            <Card.Body>
              <Card.Title> Second TODO! </Card.Title>
              <Card.Text>
                Some quick example text for todo's detail
              </Card.Text>
              <Button className="Todo-Check-Btn" type="submit">Check!</Button>
            </Card.Body>
          </Card>

        </div>
      </div>
      
      {/* app footer */}
      <footer className="App-footer">
        <h2>Project schema with React</h2>
      </footer>
    
    </div>
  );
}

export default App;
