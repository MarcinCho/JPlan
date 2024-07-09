import React from 'react';

interface ContactInfo {
    email: string;
    phone: string;
    address: string;
}

const contactInfo: ContactInfo = {
    email: 'info@example.com',
    phone: '123-456-7890',
    address: '123 Main St, Anytown, USA',
};

export const About: React.FC = () => {
    return (
        <div className="about-container">
            <h1>About Us</h1>
            <p>
                Lorem ipsum dolor sit amet consectetur, adipisicing elit. Neque hic numquam nostrum. Perspiciatis suscipit quod, possimus ducimus, dolore placeat iste eligendi saepe alias maiores expedita ut non, odit quisquam sint?
            </p>
            <h2>Contact Information</h2>
            <p>
                <strong>Email:</strong> {contactInfo.email}
            </p>
            <p>
                <strong>Phone:</strong> {contactInfo.phone}
            </p>
            <p>
                <strong>Address:</strong> {contactInfo.address}
            </p>
        </div>
    );
};