import React from "react";
import Navbar from "../Navbar";
import { Outlet } from "react-router-dom";

const Home = () => {
  return (
    <div className="home d-flex">
      <div>
        <Navbar />
      </div>
      <div className="content">
        <Outlet />
      </div>
    </div>
  );
};

export default Home;
