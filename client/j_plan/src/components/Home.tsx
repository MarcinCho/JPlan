import React, { useState, useEffect } from "react";

import { getPublicContent } from "../services/user.service";

const Home: React.FC = () => {
    const [content, setContent] = useState<string>("");

    useEffect(() => {
        getPublicContent().then(
            (response) => {
                setContent(response.data);
            },
            (error) => {
                const _content =
                    (error.response && error.response.data) ||
                    error.message ||
                    error.toString();

                setContent(_content);
            }
        );
    }, []);

    return (
        <div className="container">
            <header className="jumbotron">
                <h3>{content}</h3>
                <h1>Test</h1>
            </header>
        </div>
    );
};

export default Home;



// export const HomePage = () => {
//     return (
//       <>
//         <header className="jumbotron text-center">
//           <h1 className="display-4">Welcome to JPlan</h1>
//           <p className="lead">Your ultimate time management solution</p>
//           <a className="btn btn-primary btn-lg" href="#" role="button">
//             Get Started
//           </a>
//         </header>
  
//         <section className="container my-5">
//           <div className="row text-center">
//             <div className="col-md-4">
//               <div className="features-icon mb-3">
//                 <i className="bi bi-calendar-check"></i>
//               </div>
//               <h3>Organize</h3>
//               <p>Easily organize your tasks and schedule</p>
//             </div>
//             <div className="col-md-4">
//               <div className="features-icon mb-3">
//                 <i className="bi bi-clock"></i>
//               </div>
//               <h3>Track</h3>
//               <p>Track your time and stay on top of deadlines</p>
//             </div>
//             <div className="col-md-4">
//               <div className="features-icon mb-3">
//                 <i className="bi bi-bar-chart"></i>
//               </div>
//               <h3>Analyze</h3>
//               <p>Analyze your productivity and improve your workflow</p>
//             </div>
//           </div>
//         </section>
//       </>
//     );
//   };
  