import CompanyModel from "../models/CompanyModel";

export const Company: React.FC<{ company: CompanyModel }> = (props) => {
  return (
    <div className="">
      <div className="col-sm-8 col-md-8">
        <h5>1{props.company.companyName}</h5>
        <p>2{props.company.companyId}</p>
        <p>3{props.company.companyEmail}</p>
        <hr />
      </div>
    </div>
  );
};
