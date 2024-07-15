import { getCurrentUser } from "../../services/auth.service";
import { useState } from "react";
import TimeCardRequest from "../models/TimeCardRequest";
import authHeader from "../../services/auth-header";

export const NewTimeCard = () => {
  const currentUser = getCurrentUser();
  const username = currentUser.username;

  const [comment, setComment] = useState("");
  const [edited, setEdited] = useState(false);
  const [project, setProject] = useState("ProjectID");
  const [activeT, setActiveT] = useState(true);

  const [displayWarning, setDisplayWarning] = useState(false);
  const [displaySuccess, setDisplaySuccess] = useState(false);

  function projectField(value: string) {
    setProject(value);
  }

  async function createTimeCard() {
    if (currentUser !== null && comment !== "") {
      const url = "http://localhost:8080/timecard";
      const timeCard: TimeCardRequest = new TimeCardRequest(
        username,
        comment,
        activeT,
        edited
      );

      const reqbody = {
        username: currentUser.username,
        comment: comment,
        edited: edited,
        active: activeT,
      };
      const requestOptions = {
        method: "POST",
        headers: {
          Authorization: authHeader().Authorization,
          "Content-Type": "application/json",
        },
        body: JSON.stringify(reqbody),
      };

      const submitTimeCard = await fetch(url, requestOptions);
      if (!submitTimeCard.ok) {
        throw new Error("somethingaint right");
      } else if (submitTimeCard.ok) {
        setActiveT(false);
        setComment("");
        setEdited(false);
        setDisplaySuccess(true);
      }
    }
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
              <div className="col-md-5 mb-3">
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
              <div className="col-md-2 mb-2">
                <label className="form-check-label">Edited</label>
                <div className="form-check form-switch">
                  <input
                    className="form-check-input"
                    type="checkbox"
                    role="switch"
                    id="flexSwitchCheckDefault"
                    onChange={(e) => setEdited(e.target.checked)}
                    checked={edited}
                  />
                </div>
              </div>
              <div className="col-md-2 mb-2">
                <label className="form-check-label">Active</label>
                <div className="form-check form-switch">
                  <input
                    className="form-check-input"
                    type="checkbox"
                    role="switch"
                    id="flexSwitchCheckChecked"
                    onChange={(e) => setActiveT(e.target.checked)}
                    checked={activeT}
                  />
                </div>
              </div>
              <div className="col-md-3 mb-3">
                <label className="form-label">p</label>
                <button
                  className="form-control btn btn-secondary dropdown-toggle"
                  type="button"
                  id="dropdownMenuButton1"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  {project}
                </button>
              </div>
            </div>
            <div className="text-centered">
              <button className="btn btn-primary" onClick={createTimeCard}>
                submit
              </button>
            </div>
          </form>
        </div>
      </div>
    </div>
  );
};
