import {useFormik} from "formik";
import {useState} from "react";
import axios from "axios";

function NewRequestPage() {

    const [lengthRequest, setLengthRequest] = useState(0);
    const [selectedKindOfRequest, setSelectedKindOfRequest] = useState(null);

    const validate = values => {
        const errors = {};

        setLengthRequest(values.description.length);


        if (!values.name.match(/^[a-zA-Z]+$/)) {
            errors.name = 'Invalid characters.';
        }

        if (!values.surname.match(/^[a-zA-Z]+$/)) {
            errors.surname = 'Invalid characters.';
        }

        //todo
        if (!values.surname.match(/^[a-zA-Z]+$/)) {
            errors.surname = 'Invalid characters.';
        }

        if (lengthRequest > 5000) {
            errors.description = 'Max length description request 5000';
        }

        return errors;
    };

    const kindOfRequestSelect = (e) => {
        setSelectedKindOfRequest(e.target.value);
    }

    const formik = useFormik({
        initialValues: {
            name: "",
            surname: "",
            dateOfBirth: "",
            gender: ""
        },
        validate,
        onSubmit: values => {

            values.kindOfRequest = selectedKindOfRequest;

            axios.post(`http://localhost:8080/employee`,
                {
                    "description": values.description,
                    "kindOfRequest": values.kindOfRequest,
                    "name": values.name,
                    "policyNumber": values.policyNumber,
                    "surname": values.surname
                })
                .then((response) => {
                    console.log(response);
                    window.location.reload();
                });
        }
    });

    const [optionsKindOfRequest, setOptionsKindOfRequest] = useState([]);

    const genderOptions = [
        {
            label: "Female",
            value: 1
        },
        {
            label: "Male",
            value: 2
        },
        {
            label: "Transgender female",
            value: 3
        },
        {
            label: "Transgender male",
            value: 4
        },
        {
            label: "Prefer not the answer",
            value: 5
        },
        {
            label: "Not listed",
            value: 6
        }
    ];


    return (
        <div className="window">

            <div onClick={(e) => e.stopPropagation()}
                 className="container">

                <div className="modal-header">
                    <h1>Employee Registration Form</h1>
                </div>

                <form className="modal-form"
                      onSubmit={formik.handleSubmit}>

                    <label htmlFor="name">Name</label>
                    <input id="name"
                           className={formik.errors.name ? "error-input" : "success-input"}
                           onChange={formik.handleChange}
                           onBlur={formik.handleBlur}
                           value={formik.values.name}
                    />
                    {formik.errors.name ? <div className="error">{formik.errors.name}</div> : null}

                    <label htmlFor="surname">Surname</label>
                    <input id="surname"
                           className={formik.errors.surname ? "error-input" : "success-input"}
                           className={formik.errors.surname ? "error-input" : "success-input"}
                           onChange={formik.handleChange}
                           onBlur={formik.handleBlur}
                           value={formik.values.surname}
                    />
                    {formik.errors.surname ? <div className="error">{formik.errors.surname}</div> : null}

                    <label htmlFor="dateOfBirth">Date of Birth</label>
                    <input id="dateOfBirth"
                           className={formik.errors.dateOfBirth ? "error-input" : "success-input"}
                           onChange={formik.handleChange}
                           onBlur={formik.handleBlur}
                           value={formik.values.dateOfBirth}
                    />
                    {formik.errors.dateOfBirth ? <div className="error">{formik.errors.dateOfBirth}</div> : null}

                    {/*<div className='radio-group'>*/}
                    {/*    <b>Gender: </b>*/}
                    {/*    {genderOptions.map((option) => (*/}
                    {/*        <label>*/}
                    {/*            <input type="radio"/>*/}
                    {/*            {option}*/}
                    {/*        </label>*/}
                    {/*    ))}*/}
                    {/*</div>*/}


                    {/*<div>*/}
                    {/*    <label htmlFor="kindOfRequest">Kind of Request</label>*/}
                    {/*    <select id="kindOfRequest"*/}
                    {/*            defaultChecked={optionsKindOfRequest[0]}*/}
                    {/*            onChange={kindOfRequestSelect}>*/}
                    {/*        {optionsKindOfRequest.map((option) => (*/}
                    {/*            <option value={option}>*/}
                    {/*                {option}*/}
                    {/*            </option>*/}
                    {/*        ))}*/}
                    {/*    </select>*/}

                    {/*    <label htmlFor="policyNumber">Policy Number</label>*/}
                    {/*    <input id="policyNumber"*/}
                    {/*           className={formik.errors.policyNumber ? "error-input" : "success-input"}*/}
                    {/*           onChange={formik.handleChange}*/}
                    {/*           onBlur={formik.handleBlur}*/}
                    {/*           value={formik.values.policyNumber}*/}
                    {/*    />*/}
                    {/*    {formik.errors.policyNumber ? <div className="error">{formik.errors.policyNumber}</div> : null}*/}

                    {/*    <label htmlFor="surname">Surname</label>*/}
                    {/*    <input id="surname"*/}
                    {/*           className={formik.errors.surname ? "error-input" : "success-input"}*/}
                    {/*           onChange={formik.handleChange}*/}
                    {/*           onBlur={formik.handleBlur}*/}
                    {/*           value={formik.values.surname}*/}
                    {/*    />*/}
                    {/*    {formik.errors.surname ? <div className="error">{formik.errors.surname}</div> : null}*/}

                    {/*    <label htmlFor="description">Your request</label>*/}
                    {/*    <textarea id="description"*/}
                    {/*              className={formik.errors.description ? "error-input" : "success-input"}*/}
                    {/*              onChange={formik.handleChange}*/}
                    {/*              onBlur={formik.handleBlur}*/}
                    {/*              value={formik.values.description}*/}
                    {/*              maxLength={5000}*/}
                    {/*    >*/}
                    {/*    </textarea>*/}
                    {/*    {formik.errors.description ? <div className="error-input">{formik.errors.description}</div> : null}*/}

                    {/*    <p>{lengthRequest}/5000</p>*/}

                    {/*</div>*/}

                    <div className="button-form">
                        <button className="send-button"
                                type="submit">
                            <span>CREATE EMPLOYEE</span>
                        </button>
                    </div>

                </form>
            </div>
        </div>
    )
}

export default NewRequestPage;