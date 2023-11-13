import "./App.css";
import { Navbar, Home, Tutorials, Blogs } from "./components";
import "bootstrap/dist/js/bootstrap.bundle.min";
import { BrowserRouter, Route, Routes } from "react-router-dom";

function App() {
  return (
    <div className="app">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Home />}>
            <Route path="/:category" element={<Tutorials />} />
            <Route path="/blogs" element={<Blogs />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
