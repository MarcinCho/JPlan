import { getCurrentUser } from "../../services/auth.service";
import { useState } from "react";

export const NewTimeCard = () => {
  const currentUser = getCurrentUser();

  const [comment, setComment] = useState("");
  const [edited, setEdited] = useState(false);
  const [project, setProject] = useState("ProjectID");

  const [displayWarning, setDisplayWarning] = useState(false);
  const [displaySuccess, setDisplaySuccess] = useState(false);

  function projectField(value: string) {
    setProject(value);
  }

  return (
    <div className="container mt-5 mb-5">
      {displaySuccess && (
        <div className="alert alert-success" role="alert">
          Time card added
        </div>
      )}
      {displayWarning && (
        <div className="alert alert-danger" role="alert">
          Something went wrong?? try again or contact helpDesk.
        </div>
      )}
      <div className="card">
        <div className="card-header">Create new time card</div>
        <div className="card-body">
          <form action="" method="POST">
            <div className="row">
              <div className="col-md-6 mb-3">
                <label className="form-label">comment</label>
                <input
                  type="text"
                  className="form-control"
                  name="comment"
                  required
                  onChange={(e) => setComment(e.target.value)}
                  value={comment}
                />
              </div>
              <div className="col-md-3 mb-3">
                <label className="form-label">active</label>
                <input
                  type="checkbox"
                  className="form-control"
                  name="comment"
                  required
                  onChange={(e) => setComment(e.target.value)}
                  value={comment}
                />
              </div>
              <div className="col-md-3 mb-3">
                <label className="form-label">edited</label>
                <input
                  type="checkbox"
                  className="form-control"
                  name="edited"
                  required
                  onChange={(e) => setComment(e.target.value)}
                  value={comment}
                />
              </div>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};
