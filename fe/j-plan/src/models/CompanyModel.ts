class CompanyModel {
  companyId: string;
  companyName: string;
  companyEmail: string;
  dateCreated: string;
  constructor(companyId: string, companyName: string, companyEmail: string, dateCreated: string) {
    this.companyId = companyId;
    this.companyName = companyName;
    this.companyEmail = companyEmail;
    this.dateCreated = dateCreated;
  }
}

export default CompanyModel;
