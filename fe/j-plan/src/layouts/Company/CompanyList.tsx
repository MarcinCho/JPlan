import { useEffect, useState } from "react";
import CompanyModel from "../../models/CompanyModel";
import { Company } from "./Company";

export const CompanyList = () => {
  const [companies, setCompanies] = useState<CompanyModel[]>([]);
  const [httpError, setHttpError] = useState(null);

  useEffect(() => {
    const fetchCompanyList = async () => {
      const companyUrl: string = `http://localhost:8080/client/companies`;
      const responseCompanies = await fetch(companyUrl);

      if (!responseCompanies.ok) {
        throw new Error("Somethin went wrong");
      }
      const responseJsonCompanies = await responseCompanies.json();
      // const responseData = responseJsonCompanies._embedded.companies;
      const responseData = responseJsonCompanies;

      const loadedCompanies: CompanyModel[] = [];

      for (const key in responseData) {
        loadedCompanies.push({
          companyId: responseData[key].id,
          companyName: responseData[key].companyName,
          companyEmail: responseData[key].companyEmail,
          dateCreated: responseData[key].dateCreated,
        });
      }

      setCompanies(loadedCompanies);
    };

    fetchCompanyList().catch((error: any) => {
      setHttpError(error.message);
    });
  }, []);

  if (httpError) {
    return (
      <div>
        <p>{httpError}</p>
      </div>
    );
  }

  return (
    <div className="container m-5">
      <div className="row">
        {companies.map((company) => (
          <Company company={company} key={company.companyId} />
        ))}
      </div>
    </div>
  );
};
