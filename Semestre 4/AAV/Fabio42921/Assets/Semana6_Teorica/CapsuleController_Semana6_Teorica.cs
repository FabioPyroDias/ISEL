using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CapsuleController_Semana6_Teorica : MonoBehaviour
{
    private Rigidbody rb;
    private Camera cam;

    [SerializeField] private float force;
    [SerializeField] private float rotationSpeed;

    [SerializeField] private float shootForce;

    // Start is called before the first frame update
    void Start()
    {
        rb = GetComponent<Rigidbody>();
        cam = Camera.main;
    }

    // Update is called once per frame
    void Update()
    {
        if(Input.GetButtonUp("Fire2"))
        {
            Ray ray = cam.ScreenPointToRay(Input.mousePosition);
            RaycastHit hit;

            if(Physics.Raycast(ray, out hit))
            {
                Collider[] colliders = Physics.OverlapSphere(hit.point, 5);

                foreach(Collider collider in colliders)
                {
                    Rigidbody r = collider.GetComponent<Rigidbody>();

                    if(r != null)
                    {
                        r.AddExplosionForce(shootForce, hit.point, 5, 0, ForceMode.Impulse);
                    }
                }
            }
        }
    }

    void FixedUpdate()
    {
        float vertical = Input.GetAxis("Vertical");
        float horizontal = Input.GetAxis("Horizontal");

        rb.AddForce(transform.forward * vertical * force);

        transform.Rotate(Vector3.up * horizontal * rotationSpeed);
    }
}
