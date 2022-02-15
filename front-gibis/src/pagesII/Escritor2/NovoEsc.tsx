import React from 'react';
import { useFormik } from 'formik';
import Button from '@material-ui/core/Button';
import styles from './Escritor2.module.css'
import { TextField, Container, CssBaseline, Avatar, Typography, Grid, ThemeProvider, Checkbox, FormControlLabel, FormLabel, RadioGroup, Radio, FormHelperText, FormControl, InputLabel, Select, MenuItem, IconButton } from '@material-ui/core';
import LockOutlinedIcon from '@material-ui/icons/LockOutlined';
import { theme } from '../../theme';
import { Add } from '@material-ui/icons';
import { validationSchema } from './schema';
import { initialValues } from './formik';

export const NovoEscritor = () => {
  const formik = useFormik({
    initialValues: initialValues,
    validationSchema: validationSchema,
    onSubmit: (values) => {
      alert(JSON.stringify(values, null, 2));
    },
  });


  const [locations, setLocation] = React.useState([""]);

  const addLocation = () => {
    setLocation([...locations, ""]);
  };

  return (
    <div className={styles.wrapper}>
      <ThemeProvider theme={theme}>
        <Container component="main" maxWidth="lg">
          <CssBaseline />
          <div className={styles.paper}>
            <Avatar className={styles.avatar}>
              <LockOutlinedIcon />
            </Avatar>
            <Typography component="h1" variant="h5">
              Novo Escritor 
            </Typography>
            <form onSubmit={formik.handleSubmit} className={styles.form} noValidate>
              <Grid container spacing={2}>
                {/*Escritor */}
                <Grid item xs={12} sm={12}>
                  <Typography component="h1" variant="h6">
                    Dados do Escritor
                  </Typography>
                </Grid>
                <Grid item xs={12} sm={6}>
                  <TextField
                    name="escNome"
                    variant="outlined"
                    required
                    fullWidth
                    id="escNome"
                    label="Nome"
                    autoFocus
                    value={formik.values.escNome}
                    onChange={formik.handleChange}
                    error={formik.touched.escNome && Boolean(formik.errors.escNome)}
                    helperText={formik.touched.dogName && formik.errors.escNome}
                  />
                </Grid>
                <Grid item xs={12} sm={6} lg={3}>
                  <TextField
                    type="number"
                    variant="outlined"
                    required
                    fullWidth
                    id="escTel"
                    label="Telefone"
                    name="escTel"
                    value={formik.values.escTel}
                    onChange={formik.handleChange}
                    error={formik.touched.escTel && Boolean(formik.errors.escTel)}
                    helperText={formik.touched.escTel && formik.errors.escTel}
                  />
                </Grid>
                <Grid item xs={12} sm={12}>
                  <Typography component="h1" variant="h6">
                    Endereço do Escritor
                    <IconButton color="secondary" aria-label="add an alarm" onClick={addLocation}>
                      <Add />
                    </IconButton>
                  </Typography>
                </Grid>
                {locations.map((jump, index) => (
                  <>
                    <Grid item xs={12} sm={6} lg={6}>
                      <TextField
                        variant="outlined"
                        required
                        fullWidth
                        id="escEndr"
                        label="Endereco"
                        name="escEndr"
                        value={formik.values.escEndr}
                        onChange={formik.handleChange}
                        error={formik.touched.escEndr && Boolean(formik.errors.escEndr)}
                        helperText={formik.touched.escEndr && formik.errors.escEndr}
                      />
                    </Grid>
                  
                  </>
                ))}

                <Grid item xs={12} sm={6} lg={3}>
                  <TextField
                    variant="outlined"
                    fullWidth
                    required
                    InputLabelProps={{ shrink: true }}
                    type="date"
                    id="escDtN"
                    label="Data de nascimento"
                    name="escDtN"
                    value={formik.values.escDtN}
                    onChange={formik.handleChange}
                    error={formik.touched.escDtN && Boolean(formik.errors.escDtN)}
                    helperText={formik.touched.escDtN && formik.errors.escDtN}
                  />
                </Grid>

                <Grid item xs={12} sm={6} lg={3}>
                  <TextField
                    variant="outlined"
                    fullWidth
                    required
                    InputLabelProps={{ shrink: true }}
                    type="date"
                    id="escDtN"
                    label="Data de nascimento"
                    name="escDtN"
                    value={formik.values.escDtN}
                    onChange={formik.handleChange}
                    error={formik.touched.escDtN && Boolean(formik.errors.escDtN)}
                    helperText={formik.touched.escDtN && formik.errors.escDtN}
                  />
                </Grid>

                <Grid item xs={12} sm={6} lg={3}>
                  <TextField
                    variant="outlined"
                    fullWidth
                    required
                    InputLabelProps={{ shrink: true }}
                    type="date"
                    id="escDtF"
                    label="Data de falescimento"
                    name="escDtF"
                    value={formik.values.escDtF}
                    onChange={formik.handleChange}
                    error={formik.touched.escDtF && Boolean(formik.errors.escDtF)}
                    helperText={formik.touched.escDtF && formik.errors.escDtF}
                  />
                </Grid>

                <Grid item xs={12} sm={6} lg={3}>
                  <TextField
                    variant="outlined"
                    fullWidth
                    required
                    InputLabelProps={{ shrink: true }}
                    type="date"
                    id="escDtContr"
                    label="Data de contratação"
                    name="escDtContr"
                    value={formik.values.escDtContr}
                    onChange={formik.handleChange}
                    error={formik.touched.escDtContr && Boolean(formik.errors.escDtContr)}
                    helperText={formik.touched.escDtContr && formik.errors.escDtContr}
                  />
                </Grid>

                <Grid item xs={12} sm={6} lg={3}>
                  <TextField
                    variant="outlined"
                    fullWidth
                    required
                    InputLabelProps={{ shrink: true }}
                    type="date"
                    id="escDtDimiss"
                    label="Data de demissão"
                    name="escDtDimiss"
                    value={formik.values.escDtDimiss}
                    onChange={formik.handleChange}
                    error={formik.touched.escDtDimiss && Boolean(formik.errors.escDtDimiss)}
                    helperText={formik.touched.escDtDimiss && formik.errors.escDtDimiss}
                  />
                </Grid>

                <Button
                  type="submit"
                  fullWidth
                  variant="contained"
                  color="primary"
                  className={styles.submit}
                >
                  Enviar
                </Button>
              </Grid>
            </form>
          </div>
        </Container>
      </ThemeProvider >
    </div >
  );
};