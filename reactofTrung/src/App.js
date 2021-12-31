import './App.css';
import React from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
import logo from './components/theme/logo.png';
import {
  BrowserRouter,
  Switch,
  Route,
  Link
} from 'react-router-dom'
import Products from './components/products/Products'
import Categories from './components/categories/Categories'
import Oder from './components/oder/Oder'
import { Typography, Box } from '@material-ui/core';

function App() {
  return (
    <BrowserRouter>
      <Box maxWidth='sm' >
        <Typography style={{
          backgroundColor: 'lightGreen',
          textAlign: 'center'
        }}>
          <Link to='/products'>
            {React.createElement('img', { src: logo })}
          </Link></Typography>
        <div style={{ minHeight: '100vh' }}>
          <nav>
            <ul>
              <li><Link to='/'>Trang chủ</Link></li>
              <li><Link to ='/'>Hàng mới</Link></li>
              <li><Link to ='/'>Tư vấn</Link></li>
              <li className='sub-menu'>
                {/* bat dau sub menu */}
                <Link to="/products" className='sub-menu'>Quản lý</Link>
                <ul className='sub-menu'>
                  <li>
                    <Link to="/products">Products</Link>
                  </li>
                  <li>
                    <Link to="/categories">Categories</Link>
                  </li>
                  <li>
                    <Link to="/oder">Oder</Link>
                  </li>
                </ul>
                {/* ket thuc sub menu */}
              </li>
            </ul>

          </nav>

          <Switch>
            <Route path="/products">
              <Products />
            </Route>
            <Route path="/categories">
              <Categories />
            </Route>
            <Route path="/oder">
              <Oder />
            </Route>
          </Switch>
        </div>
        {/* <Products/> */}
        <Box style={{ width: '100%', backgroundColor: 'lightGreen', textAlign: 'center' }}>Make by TRUNGND</Box>
      </Box>
    </BrowserRouter >
  )
};

export default App;
