// import './text.css'
import TextField from '@material-ui/core/TextField';
import Avatar from '@material-ui/core/Avatar';
// import { deepOrange, deepPurple } from '@material-ui/core/colors'

// import TextField from '@material-ui/core/TextField';
import Button from '@material-ui/core/Button';
function CreateCategories({onFormSupmit, formData, onInputChange,onResetForm }) {

    return (

        <div>
            
            <div className="Form">
                <form
                    onSubmit={onFormSupmit}
                    autoComplete="off">
                    <TextField
                        name="id"
                        disabled
                        value={formData.id}
                        onChange={onInputChange}
                        fullWidth
                        label="Id" />

                    <TextField
                        name="name"
                        value={formData.name}
                        onChange={onInputChange}
                        fullWidth
                        label="Name" />
                    
                </form>
                <Button
                    onClick ={onFormSupmit}
                    type="submit"
                    variant="contained"
                    color="primary"
                    style={{ marginTop: '10px' }}
                    >
                    Submit
                </Button>
                <Button
                    type="reset"
                    onClick = {onResetForm}
                    variant="contained"
                    color="primary"
                    style={{ marginTop :'10px'  }}
                    >
                    Reset
                </Button>
            </div>

            

        </div>
    )
}
export default CreateCategories;