import {useFilters, usePagination, useTable} from "react-table";
import {useEffect, useState} from "react";
import axios from "axios";
import {baseUrl} from "../../config/const";
import authHeader from "../services/auth-header";

const Filter = ({column}) => {
    const {filterValue, setFilter} = column;

    return (
        <span>
                <input value={filterValue} onChange={(e) => setFilter(e.target.value)}
                       className={'input-primary search sh sm'} placeholder={'Search text…'}/>
            </span>
    )
}

function AllRequestsPage() {

    const columnsHeader = [
        {
            label: "Kind of Request",
            accessor: "kind of Request",
            Filter: Filter
        },
        {
            label: "Policy Number",
            accessor: "policy Number",
            Filter: Filter
        },
        {
            label: "Name",
            accessor: "name",
            Filter: Filter
        },
        {
            label: "Surname",
            accessor: "surname",
            Filter: Filter
        },
        {
            label: "Email",
            accessor: "email",
            Filter: Filter
        },
        {
            label: "Request",
            accessor: "request",
            Filter: Filter
        }
    ];


    const {
        getTableProps,
        getTableBodyProps,
        headerGroups,
        page,
        nextPage,
        previousPage,
        canNextPage,
        canPreviousPage,
        pageOptions,
        state,
        prepareRow,
    } = useTable({
            columnsHeader,
            requests,
            initialState: {
                pageSize: 6
            },
        },
        useFilters,
        usePagination
    );

    const [requests, setRequests] = useState([]);

    useEffect(async () => {
        const fetchRequests = await Promise.any([
                axios.get(`${baseUrl}/requests`,
                    {headers: authHeader()})
            ]
        )

        setRequests(fetchRequests.data)
    }, [])

    return (
        <div className="window">
            <div className="modal-header">
                <h1>Requests</h1>
            </div>

            <table>
                <thead>
                <tr>
                    {columnsHeader.map(column => <th>{column.label}</th>)}
                    <th></th>
                </tr>
                </thead>
                <tbody>
                {requests.map(request => {
                    return (
                        <tr>
                            <td>{request.kindOfRequest}</td>
                            <td>{request.policyNumber}</td>
                            <td>{request.name}</td>
                            <td>{request.surname}</td>
                            <td>{request.email}</td>
                            <td>{request.request}</td>
                            <td>
                                <button className="button-primary sm"
                                        type="submit">
                                    <span>SELECT</span>
                                </button>
                                <button className="button-primary sm"
                                        type="submit">
                                    <span>DELETE</span>
                                </button>
                            </td>
                        </tr>
                    )
                })}
                </tbody>
            </table>
        </div>
    )
}

export default AllRequestsPage;