class CompanyModel {
  companyId: string;
  companyName: string;
  companyEmail: string;
  constructor(companyId: string, companyName: string, companyEmail: string) {
    this.companyId = companyId;
    this.companyName = companyName;
    this.companyEmail = companyEmail;
  }
}

export default CompanyModel;
