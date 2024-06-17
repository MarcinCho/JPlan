import CompanyModel from "../../models/CompanyModel";

export const Company: React.FC<{ company: CompanyModel }> = (props) => {
  return (
    <div className="">
      <div className="col-sm-8 col-md-8">
        <h5>{props.company.companyName}</h5>
        <p>{props.company.companyId}</p>
        <p>{props.company.companyEmail}</p>
      </div>
    </div>
  );
};
