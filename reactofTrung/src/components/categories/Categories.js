// import './../phone.css'
import { useState, useEffect } from 'react';
import ListCategories from './ListCategories';
import React from 'react';
import CssBaseline from '@material-ui/core/CssBaseline';
import Typography from '@material-ui/core/Typography';
import Container from '@material-ui/core/Container';
import CreateCategories from './CreateCategories';

import axios from 'axios';
import Backdrop from '@material-ui/core/Backdrop';
import CircularProgress from '@material-ui/core/CircularProgress';
function Categories (){
    const [listDanhMuc, setListDanhMuc] = useState([]);
    const [danhMucId,setDanhMucId] = useState(-1);
    const [student, setStudent] = useState([]);
    const [products, setProducts] = useState([]);
    const [clickRow, setClickRow] = useState(-1);
    const [formData, setFormData] = useState({
        id: '',
        CategoriesID:'0',
        name: '',
        price: '',
    });
    const [error, setError] = useState('');
    const [loading, setLoading] = useState(false);
    const onClickRow = (event, value, index) => {
        setClickRow(index);
        setFormData(value);
    }
    const onInputChange = (event) => {
        const { name, value } = event.target;

        setFormData({
            ...formData,
            [name]: value,
        });
    }
    const limit = 10;
    const pageInit = 1;
    const [page, setPage] = useState(pageInit);
    const url = 'https://6012527d84695f001777a028.mockapi.io/categories/?limit=' + limit +
    "&page=" + page;
    
    useEffect(() => {
       
        

        setLoading(true)
        axios({
            method: 'Get',
            url: url,
        })

            .then((repsonse) => {
                const { data } = repsonse
                console.log(data)
                setProducts(data)
                setLoading(false);
            })
            .catch((error) => {
                console.log(error, error.repsonse)
                setLoading(false);
                setError(error.massage);
            });
    }, [
        page
    ]);
    useEffect(() => {
        setLoading(true);
        const apiDanhMucUrl = 'https://6012527d84695f001777a028.mockapi.io/categories';
        axios.get(apiDanhMucUrl)
            .then(function (response) {
                const { data } = response;
                console.log(data)
                setListDanhMuc(data);
                setLoading(false);
            })
            .catch(function (error) {
                console.log(error)
            })
    }, []);
const danhMucOnChange = function(event){
console.log();
setDanhMucId(event.target.value);
setPage(1);
}
    const onCrateProduct = () => {

        const urlApiThemMoi = 'https://6012527d84695f001777a028.mockapi.io/categories' ;
        axios.post(urlApiThemMoi, formData)
            .then(function (response) {
                console.log('response');
                console.log(response);
                const { data } = response;
                setProducts([
                    ...products,
                    formData,
                ]);
            })
            .catch(function (error) {
                console.error('error');
                console.error(error);
            })
    }
    const onUpdateProduct = function () {
        const apiUpdate = 'https://6012527d84695f001777a028.mockapi.io/categories' + formData.id;
        axios.put(apiUpdate, formData)
            .then(function (response) {
                console.log('response')
                console.log(response)
                const listProductNew = products.map(function (val, idx) {
                    if (val.id == formData) {
                        return response.data;
                    } else {
                        return val;
                    }
                });
                setProducts(listProductNew)
            })
            .catch(function (error) {
                console.log('error', error);
                setError(error.message);
            });
    }
    const onFormSupmit = (event) => {
        event.preventDefault();
        if (clickRow == -1) {
            onCrateProduct();
        } else {
            onUpdateProduct();
        }
    }
    const onResetForm = () => {
        setError('');
        setClickRow(-1);
        setFormData({
            id: '',
            name: '',
            price: ''
        });
    }
    const btnDeleteOnClick = function (event, value, index) {
        event.stopPropagation();
        console.log(value, index)
        const apiXoaUrl = `https://6012527d84695f001777a028.mockapi.io/categories/${value.id}`;
        axios.delete(apiXoaUrl)
            .then(function (response) {
                const listNew = products.filter(function (val, idx) {
                    if (idx == index) {
                        return false; // loaij bo phan tu

                    } else {
                        return true; // giu lai phan tu
                    }
                });
                setProducts(listNew);
            })
            .catch(function (error) {
                console.error('error');
                console.error(error);

            })
    }
    const trangTruoc = function () {
        if (page == 1) {
            return;
        }
        setPage(page - 1);
    }
    const trangSau = function () {
        setPage(page + 1);
    }

    return (
        <div>
            {/* <Student student={student} /> */}
            {/* <Input/> */}
            {/* <ClickCount /> */}
            <React.Fragment>
                <CssBaseline />
                <Container >
                    <Typography component="div" style={{ backgroundColor: '#cfe8fc' }} >
                        <Backdrop  
                        style={{zIndex:1000}}
                        open={loading}>
                            <CircularProgress />
                        </Backdrop>
                        <div className={
                            error.length == 0 ?
                                'd-none' :
                                'alert alert-danger'
                        }
                            role="alert"
                        >
                            {error}
                        </div>
                        <CreateCategories

                            onFormSupmit={onFormSupmit}
                            onInputChange={onInputChange}
                            onResetForm={onResetForm}
                            formData={formData} />
                       
                        <ListCategories

                            btnDeleteOnClick={btnDeleteOnClick}
                            onClickRow={onClickRow}
                            listPhon={products}
                        />
                        {/* <EnhancedTable products={products}/> */}
                        <ul className="paginations mt4 mb-4" >
                            <li
                                onClick={trangTruoc}
                                className="page-item">
                                <a className="page-link"> Trang truoc</a>
                            </li>

                            <li className="page-item">
                                <a className="page-link"> {page}</a>
                            </li>

                            <li
                                onClick={trangSau}
                                className="page-item">
                                <a className="page-link">Trang sau</a>
                            </li>
                        </ul>

                    </Typography>
                </Container>

            </React.Fragment>
            {/* ); */}

        </div>
    );
    
}
export default Categories