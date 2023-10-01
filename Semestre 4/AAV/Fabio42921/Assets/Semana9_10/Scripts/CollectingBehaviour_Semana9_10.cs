using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CollectingBehaviour_Semana9_10 : StateMachineBehaviour
{
    private Semana9_10_CapsuleController player;
    private Transform target;

    // OnStateEnter is called when a transition starts and the state machine starts to evaluate this state
    override public void OnStateEnter(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        player = animator.transform.GetComponent<Semana9_10_CapsuleController>();
        target = player.GetTarget();

        if(target == null)
        {
            animator.SetBool("detectedPickable", false);
        }
        else
        {
            player.SetDestination(target);
        }
    }

    //OnStateUpdate is called on each Update frame between OnStateEnter and OnStateExit callbacks
    override public void OnStateUpdate(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    {
        if(player.GetRemainingDistance() < 0.1f)
        {
            animator.SetBool("detectedPickable", false);
        }
    }

    // OnStateExit is called when a transition ends and the state machine finishes evaluating this state
    //override public void OnStateExit(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    //{
    //
    //}

    // OnStateMove is called right after Animator.OnAnimatorMove()
    //override public void OnStateMove(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    //{
    //    // Implement code that processes and affects root motion
    //}

    // OnStateIK is called right after Animator.OnAnimatorIK()
    //override public void OnStateIK(Animator animator, AnimatorStateInfo stateInfo, int layerIndex)
    //{
    //    // Implement code that sets up animation IK (inverse kinematics)
    //}
}
