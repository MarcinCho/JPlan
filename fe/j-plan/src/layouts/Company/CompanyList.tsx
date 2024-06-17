import { useEffect, useState } from "react";
import CompanyModel from "../../models/CompanyModel";
import { Company } from "./Company";

export const CompanyList = () => {
  const [companies, setCompanies] = useState<CompanyModel[]>([]);

  useEffect(() => {
    const fetchCompanyList = async () => {
      const companyUrl: string = `http://localhost:8080/api/companies`;
      const responseCompanies = await fetch(companyUrl);

      if (!responseCompanies) {
        throw new Error("Somethin went wrong");
      }

      const responseJsonCompanies = await responseCompanies.json();
      const responseData = responseJsonCompanies._embedded.reviews;

      const loadedCompanies: CompanyModel[] = [];

      for (const key in responseData) {
        loadedCompanies.push({
          companyId: responseData[key].companyId,
          companyName: responseData[key].companyName,
          companyEmail: responseData[key].ComapnyEmail,
        });
      }

      setCompanies(loadedCompanies);
    };

    // fetchCompanyList().catch((error.any => ));
  }, []);

  return (
    <div className="container m-5">
      <div className="row">{companies.map((company)=> (<Company: company={company} key={company.id}))}</div>
    </div>
  );
};

//       setReviews(loadedReviews);
//       setIsLoading(false);
//     };

//     fetchBookReviews().catch((error: any) => {
//       setIsLoading(false);
//       setHttpError(error.message);
//     });
//   }, [currentPage]);

//   if (isLoading) {
//     return <SpinnnerLoading />;
//   }

//   if (httpError) {
//     return (
//       <div className="container m-5">
//         <p></p>
//       </div>
//     );
//   }

//   const indexOfLastReview: number = currentPage * reviewsPerPage;
//   const indexOfFirstReview: number = indexOfLastReview - reviewsPerPage;

//   let lastItem =
//     reviewsPerPage * currentPage <= totalAmountOfReviews
//       ? reviewsPerPage * currentPage
//       : totalAmountOfReviews;

//   const paginate = (pageNumber: number) => setCurrentPage(pageNumber);

//   return (
//     <div className="container m-5">
//       <div>
//         <h3>Comments: ({reviews.length})</h3>
//       </div>
//       <p>
//         {indexOfFirstReview + 1} to {lastItem} of {totalAmountOfReviews} items:
//       </p>
//       <div className="row">
//         {reviews.map((review) => (
//           <Review review={review} key={review.id} />
//         ))}
//       </div>
//       {totalPages > 1 && (
//         <Pagination
//           currentPage={currentPage}
//           totalPages={totalPages}
//           paginate={paginate}
//         />
//       )}
//     </div>
//   );
