import { useEffect, useState } from "react";
import CompanyModel from "../models/CompanyModel";
import { Company } from "./Company";
import authHeader from "../../services/auth-header";
import axios from "axios";

export const CompanyList = () => {
  const [companies, setCompanies] = useState<CompanyModel[]>([]);
  const [httpError, setHttpError] = useState(null);

  useEffect(() => {
    const header = authHeader();
    console.log(header);

    const fetchCompanyList = async () => {
      const companyUrl: string = `http://localhost:8080/api/companies`;
      const responseCompanies = await fetch(companyUrl, {
        method: "GET",
        headers: header,
      });

      if (!responseCompanies.ok) {
        throw new Error("Somethin went wrong");
      }
      const responseJsonCompanies = await responseCompanies.json();
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
