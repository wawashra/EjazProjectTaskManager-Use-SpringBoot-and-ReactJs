import React, { Component } from "react";
import "./App.css";
import Dashbord from "./components/Dashbord";
import Header from "./components/Layout/Header";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddProject from "./components/Project/AddProject";
import Login from "./components/Layout/Login";
import Register from "./components/Layout/Register";
class App extends Component {
  render() {
    return (
      <Router>
        <div className="App">
          <Header />
          <Route exact path="/DashBord" component={Dashbord} />
          <Route exact path="/Addproject" component={AddProject} />
          <Route exact path="/Login" component={Login} />
          <Route exact path="/register" component={Register} />
        </div>
      </Router>
    );
  }
}

export default App;
