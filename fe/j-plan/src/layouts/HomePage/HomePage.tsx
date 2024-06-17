export const HomePage = () => {
  return (
    <>
      <header className="jumbotron text-center">
        <h1 className="display-4">Welcome to JPlan</h1>
        <p className="lead">Your ultimate time management solution</p>
        <a className="btn btn-primary btn-lg" href="#" role="button">
          Get Started
        </a>
      </header>

      <section className="container my-5">
        <div className="row text-center">
          <div className="col-md-4">
            <div className="features-icon mb-3">
              <i className="bi bi-calendar-check"></i>
            </div>
            <h3>Organize</h3>
            <p>Easily organize your tasks and schedule</p>
          </div>
          <div className="col-md-4">
            <div className="features-icon mb-3">
              <i className="bi bi-clock"></i>
            </div>
            <h3>Track</h3>
            <p>Track your time and stay on top of deadlines</p>
          </div>
          <div className="col-md-4">
            <div className="features-icon mb-3">
              <i className="bi bi-bar-chart"></i>
            </div>
            <h3>Analyze</h3>
            <p>Analyze your productivity and improve your workflow</p>
          </div>
        </div>
      </section>
    </>
  );
};
